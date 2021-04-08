<?php
    // 03022021.2 : API stable with authentication
    // Versi dengan hanya parameter Username & Password untuk login

    include '../config/connection.php';

    if($_SERVER['REQUEST_METHOD'] == 'POST') {
        $cekusername = $_POST['username'];
        $cekpassword = $_POST['password'];

        $proseslogin = mysqli_query($_AUTH, "SELECT id_user, username, password, hash_useraccess, level, dateuser_created FROM tbl_user WHERE username = '$cekusername' AND password = MD5('$cekpassword')");
        
        $getfieldlogin = mysqli_fetch_assoc($proseslogin);

        $existuser = mysqli_query($_AUTH, "SELECT COUNT(*) 'total' FROM tbl_user WHERE username = '$cekusername' AND password = MD5('$cekpassword')");
        $totaldata = mysqli_fetch_assoc($existuser);

        if ($totaldata['total'] == 0) {
            $response["message"] = "Maaf, Anda gagal melakukan login kedalam aplikasi, silahkan cek user credensial anda!";
            $response["code"] = 404;
            $response["status"] = false;

            echo json_encode($response);
        } else {

            $passwd = $getfieldlogin['password'];
            
            $cek_authentikasi = mysqli_query($_AUTH, "SELECT COUNT(*) 'existuser' FROM tbl_user WHERE username = '$cekusername' AND password = '$passwd'");
            $requireauth = mysqli_fetch_assoc($cek_authentikasi);
            
            if ($requireauth['existuser'] == 0) {
            } else {
                $response["message"] = "Congratulation! Anda berhasil login atas nama " .$cekusername;
                $response["code"] = 200;
                $response["status"] = true;
    
                $response["id"] = $getfieldlogin['id_user'];
                $response["user"] = $getfieldlogin['username'];
                $response["pass"] = $getfieldlogin['password'];
                $response["hash"] = $getfieldlogin['hash_useraccess'];
                $response["level"] = $getfieldlogin['level'];
                $response["created_at"] = $getfieldlogin['dateuser_created'];
            
                echo json_encode($response);
            }
        }
        
    } else {
        $response["message"] = trim("Oops! Sory, Request API ini membutuhkan parameter!.");
        $response["code"] = 400;
        $response["status"] = false;

        echo json_encode($response);
    }

?>
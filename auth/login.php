<?php
    // 03022021.2 : API stable with authentication
    // Versi dengan hanya parameter Username & Password untuk login

    include '../config/connection.php';

    if($_SERVER['REQUEST_METHOD'] == 'POST') {
        $cekusername = $_POST['username'];
        $cekpassword = $_POST['password'];

        $proseslogin = mysqli_query($_AUTH, "SELECT id_user, username, password, hash_useraccess, level, dateuser_created FROM tbl_user WHERE username = '$cekusername' AND password = MD5('$cekpassword')");

        $existuser = mysqli_query($_AUTH, "SELECT COUNT(*) 'total' FROM tbl_user WHERE username = '$cekusername' AND password = MD5('$cekpassword')");
        $totaldata = mysqli_fetch_assoc($existuser);

        if ($totaldata['total'] == 0) {
            $response["message"] = "Maaf, Anda gagal melakukan login kedalam aplikasi, silahkan cek user credensial anda!";
            $response["code"] = 404;
            $response["status"] = false;

            echo json_encode($response);
        } else {
            $response["message"] = "Congratulation! Anda berhasil login atas nama " .$cekusername;
            $response["code"] = 200;
            $response["status"] = true;
            $response["datauserlogin"] = array();
            
            while($row = mysqli_fetch_array($proseslogin)) {
                $data = array();

                $data['id_user'] = $row['id_user'];
                $data['username'] = $row['username'];
                $data['password'] = $row['password'];
                $data['hash_useraccess'] = $row['hash_useraccess'];
                $data['level'] = $row['level'];
                $data['dateuser_created'] = $row['dateuser_created'];

                array_push($response['datauserlogin'], $data);
            }

            echo json_encode($response);
        }
        
    } else {
        $response["message"] = trim("Oops! Sory, Request API ini membutuhkan parameter!.");
        $response["code"] = 400;
        $response["status"] = false;

        echo json_encode($response);
    }

?>
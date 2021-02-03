<?php
    // 03022021.2 : API stable with authentication

    include '../config/connection.php';

    if($_SERVER['REQUEST_METHOD'] == 'POST') {
        $search_username = $_POST['username']; // aji

        // Pengecekan untuk username ada atau tidak
        $cari_username = mysqli_query($_AUTH, "SELECT COUNT(username) 'totaldata' FROM tbl_user WHERE username = '$search_username'");
        $exe_cariusername = mysqli_fetch_assoc($cari_username);

        if ($exe_cariusername['totaldata'] == 0) {
            // echo "Posible / memungkinkan menambahkan username ini kedalam database";
            $key = $_POST['password'];
            $hashuser = $_POST['hash_useraccess'];
            $leveluser = $_POST['level'];

            // Jika username bisa di inputkan dan proses input berhasil
            $tambahuser = mysqli_query($_AUTH, "INSERT INTO tbl_user (username, password, hash_useraccess, level) VALUES ('$search_username', MD5('$key'), SHA1('$hashuser'), '$leveluser')");

            // Ngecek username yang sudah ditambahkan ke database ada atau tidak, kalo ada berarti berhasil menambahkan
            $detectuser = mysqli_query($_AUTH, "SELECT COUNT(username) 'useradded' FROM tbl_user WHERE username = '$search_username'");
            $fetch_detect = mysqli_fetch_assoc($detectuser);

            if ($fetch_detect['useradded'] >= 0) {
                $fielddata = mysqli_query($_AUTH, "SELECT id_user, username, password, hash_useraccess, level, dateuser_created
                FROM tbl_user WHERE username = '$search_username'");
                
                $response["message"] = "User dengan name " . $fetch_detect['username'] . " berhasil ditambahkan kedalam database";
                $response["code"] = 201;
                $response["status"] = true;
                $response["userbaru"] = array();

                while($row = mysqli_fetch_array($fielddata)) {
                    $data = array();

                    $data['id_user'] = $row['id_user'];
                    $data['username'] = $row['username'];
                    $data['password'] = $row['password'];
                    $data['hash_useraccess'] = $row['hash_useraccess'];
                    $data['level'] = $row['level'];
                    $data['dateuser_created'] = $row['dateuser_created'];

                    array_push($response['userbaru'], $data);
                }

                echo json_encode($response);
            }

        } else {
            // echo "Imposible / tidak memungkinkan menambahkan username ini kedalam database, karena data tersedia didatabase";
            $response["message"] = "Imposible / tidak memungkinkan menambahkan username ini kedalam database, karena data tersedia didatabase";
            $response["code"] = 405;
            $response["status"] = false;
            echo json_encode($response);
        }

    } else {
        $response["message"] = trim("Oops! Sory, Request API ini membutuhkan parameter!.");
        $response["code"] = 400;
        $response["status"] = false;

        echo json_encode($response);
    }

?>
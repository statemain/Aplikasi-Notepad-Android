<?php

    // Tag: 190121.2

    include '../config/connection.php';

    if($_SERVER['REQUEST_METHOD'] == 'POST') {
        // Ketika membuat variable boleh bebas, sesuai ketentuan
        // Jangan spasi, diawali dengan angka, simbol atau yang lainnya
        $username = $_POST['username'];
        $password = $_POST['password'];
        $hash_access = $_POST['hash_useraccess'];
        $level_user = $_POST['level'];

        // Deklarasikan dulu Query dalam Variable
        // $variable = mysqli_query($_variable_authentikasi, query)
        $querysearch_user = mysqli_query($_AUTH, "SELECT * FROM tbl_user WHERE username = '$username' AND password = MD5('$password') AND hash_useraccess = SHA1('$hash_access') AND level = '$level_user'");

        $response = array();

        // mysqli_num_rows = berfungsi untuk membaca total data yang diatmpilkan ketika query di execute
        $execute_querylogin = mysqli_num_rows($querysearch_user);

        // Berfungsi untukmencari id_user yang diinputkan melalui parameter usernmae dicari juga berdasasrkan usernamenya
        $cari_iduser = "SELECT id_user FROM tbl_user WHERE username = '$username'";
        $execute_cariiduser = mysqli_query($_AUTH, $cari_iduser);
        $getid_user = mysqli_fetch_assoc($execute_cariiduser);

        $id_user_result = $getid_user['id_user'];

        if ($execute_querylogin > 0) {
            // Berhasil login
            $get_idnotes = $_POST['id_notes']; 

            $query_mencaridatanotes = "SELECT COUNT(*) total_data FROM tbl_notes WHERE id_notes = $get_idnotes";
            $execute_caridatanote = mysqli_query($_AUTH, $query_mencaridatanotes);
            $get_ketersediaan_data = mysqli_fetch_assoc($execute_caridatanote);

            if($get_ketersediaan_data['total_data'] > 0) {

                $query_tampilkandatahasilcari = "SELECT * FROM tbl_notes WHERE id_notes = $get_idnotes";
                $execute_tampilkandatanote = mysqli_query($_AUTH, $query_tampilkandatahasilcari);

                // Untuk menampilkan informasi

                $response['message'] = "Data notes dengan id $get_idnotes tersedia di database, dan list berhasil ditampilkan";
                $response['code'] = 201;
                $response['status'] = true;
                $response['datasearched'] = array();


                while($row = mysqli_fetch_array($execute_tampilkandatanote)) {

                    $data = array();

                    $data['id_notes'] = $row['id_notes'];
                    $data['titleof_notes'] = $row['titleof_notes'];
                    $data['contentof_notes'] = $row['contentof_notes'];
                    $data['date_created'] = $row['date_created'];
                    $data['id_user'] = $row['id_user'];
                    $data['categoryof_notes'] = $row['categoryof_notes'];

                    array_push($response['datasearched'], $data);
                }

                echo json_encode($response);
            } else {

                // Data tidak tersedia didatabase

                $response['message'] = "Data notes dengan id $get_idnotes tidak tersedia di database";
                $response['code'] = 404;
                $response['status'] = false;
                echo json_encode($response);
            }

        } else {
            // Gagal login
            $response["message"] = trim("Autentikasi gagal, Cek kembali user credential anda.");
            $response["code"] = 401;
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
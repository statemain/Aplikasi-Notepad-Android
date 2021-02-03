<?php
    // 03022021.2 : API stable with authentication

    // Tag: 180121.2

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
            $title_note = $_POST['titleof_notes'];
            $content_note = $_POST['contentof_notes'];
            $category_note = $_POST['categoryof_notes'];

            $query_tambahnotes = "INSERT INTO tbl_notes (titleof_notes, contentof_notes, id_user, categoryof_notes) VALUES ('$title_note', '$content_note', $id_user_result, '$category_note')";

            if(mysqli_query($_AUTH, $query_tambahnotes)) {
                $query_tampilkanlistdatanote = "SELECT * FROM tbl_notes ORDER BY id_notes ASC";
                $execute_viewlistdatanote = mysqli_query($_AUTH, $query_tampilkanlistdatanote);

                $query_totalnotes = "SELECT COUNT(*) 'total_keseluruhan_notes' FROM tbl_notes";
                $execute_totalnotes = mysqli_query($_AUTH, $query_totalnotes);
                $get_totalnotes = mysqli_fetch_assoc($execute_totalnotes);

                // Untuk menampilkan informasi
                $response['message'] = "Data notes berhasil ditambahkan kedalam database dan list berhasil ditampilkan";
                $response['code'] = 201;
                $response['status'] = true;
                $response['totalnotes'] = $get_totalnotes['total_keseluruhan_notes'];
                $response['datanotes'] = array();

                while($row = mysqli_fetch_array($execute_viewlistdatanote)) {

                    $data = array();

                    $data['id_notes'] = $row['id_notes'];
                    $data['titleof_notes'] = $row['titleof_notes'];
                    $data['contentof_notes'] = $row['contentof_notes'];
                    $data['date_created'] = $row['date_created'];
                    $data['id_user'] = $row['id_user'];
                    $data['categoryof_notes'] = $row['categoryof_notes'];

                    array_push($response['datanotes'], $data);
                }

                echo json_encode($response);
            }

        } else {
            // Login gagal
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
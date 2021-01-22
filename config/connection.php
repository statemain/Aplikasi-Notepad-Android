<?php

    // Tag: 150121.2

    $_SERVER_DB = "localhost";
    $_USERNAME_DB = "root";
    $_PASSWORD_DB = "!!&21adi";
    $_DATABASE_DB = "db_notepadinhand";

    $_AUTH = mysqli_connect($_SERVER_DB, $_USERNAME_DB, $_PASSWORD_DB, $_DATABASE_DB);

    if ($_AUTH) {
        // echo json_encode(array(
        //     "message" => "Congratulation!, your connection is successfully. To database ".$_DATABASE_DB, 
        //     "code" => 200, 
        //     "status" => true)
        // );
    } else {        
        // echo json_encode(array(
        //     "message" => "Sorry!, your connection is FAILED!. To connect database ".$_DATABASE_DB . " Please check your connection files.", 
        //     "code" => 404, 
        //     "status" => false)
        // );
    }
?>
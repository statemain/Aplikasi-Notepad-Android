Hi, Ini adalah project notes untuk pelajar di SMK Rabbaanii

### 12 Jan 2021 : Membuat API untuk Aplikasi Notes Bag. #1
* Tambahkan data kedalam table user minimal 5 data yang berbeda, Tambahkan kedalam table notes minimal 5 data dimana kategori untuk notes, task & todo masing-masing 5 datanya.
* Tulis article dari tahapan awal yang ada di vidio sampai menambahkan data tersebut. Lalu kirim ke email se.esemka@rbs.sch.id dengan subject judul diatas.

### 13 Jan 2021 : Mengubah Directory Root pada XAMPP Control Panel (Web Server)
* Ubah default root akses dari C:/xampp/htdoc/
* Pindahkan ke D:/nativeapi/
* Tulis article dari tahapan awal yang ada di vidio sampai menambahkan data tersebut. Lalu kirim ke email se.esemka@rbs.sch.id dengan subject judul diatas.

### 14 Jan 2021 : Menambahkan Folder Module dan Config, Melakukan Testing Connection dan Menampilkan List Notes dari API kedalam Postman
* Menambahkan file configurasi > connection.php
* Menambahkan file list_notes berdasarkan akses user dan kategori
* Tulis article dari tahapan awal yang ada di vidio sampai menambahkan data tersebut. Lalu kirim ke email se.esemka@rbs.sch.id dengan subject judul diatas.

### 15 Jan 2021 : Pendalaman Materi pembangunan API pada Pertemuan 14 Jan 2021
Berikut pendalaman materi dengan memahami alur proses aplikasi Notedpad yang sedang dalam pembangunan, pada tahapan ini kita fokus membangun dan mempersiapkan backend untuk nantinya digunakan di aplikasi client kita (Tag: 150121.2)

<img src="https://github.com/eljitech/notepadinhand/blob/master/pictures/github/Screenshot%20from%202021-01-15%2010-39-55.png"/>

### 18 Jan 2021 : Menambahkan Module Create Note dan Testing dengan Postman (Backend)
* Menambahkan Module Create Note untuk backend PHP yang akan digunakan untuk jalur penghubung antara Client dan Server | <a href="https://github.com/eljitech/notepadinhand/releases/tag/180121.2">Check it</a>

<img src="https://github.com/eljitech/notepadinhand/blob/master/pictures/github/Screenshot%20from%202021-01-18%2014-43-09.png"/>

* <a href="https://github.com/eljitech/notepadinhand/blob/master/database/180121_db_notes.sql">Update database bisa diambil disini, silahkan export untuk testing dengan database terbaru ini</a>

### 19 Jan 2021 : Backend / Native API Aplikasi Notes (Stable Rilis)
* Penambahan module Search, Update & Delete
* Module CRUDS Sudah Selesai
* Download Stable Rilis 190121.2 <a href="https://github.com/eljitech/notepadinhand/releases/tag/190121.2">Here</a>

### 25 Jan 2021 : Update List Notes (Backend) API, dan Penambahan Project Android
* Menampilkan List Notes dari database ke Android melalui API

<img src="https://github.com/eljitech/notepadinhand/blob/master/pictures/github/Peek%202021-01-25%2015-15.gif"/>

* Update list_notes.php (Pembaharuan Query)

<img src="https://github.com/eljitech/notepadinhand/blob/master/pictures/github/Screenshot%20from%202021-01-25%2015-16-31.png"/>

<img src="https://github.com/eljitech/notepadinhand/blob/master/pictures/github/Screenshot%20from%202021-01-25%2015-16-46.png"/>

<b>Ingat pesan saya, pakai metode ATM (Amati, tiru dan modifikasi), ikuti dulu step nya sampai program berjalan, apabila ada terdapat materi yang belum faham silahkan tanyakan.</b>

### 26 Jan 2021 : Solve & Cover Problem
* Implement to article
* And report to Email

### 27 Jan 2021 : Update Fiture list notes berdasarkan category notes To do dan Task
* Menampilkan List Notes berdasarkan Kategori Task dan To do
* Memahami konsep View pemanggilan layout dengan tag <include> di .XML
* Mengambil Data dari API berdasarkan kategori List notes melalui API
* Issue yang harus diselesaikan <a href="https://github.com/eljitech/attendance/issues/1">LIHAT DISINI</a>

<img src="https://github.com/eljitech/notepadinhand/blob/master/pictures/github/Peek%202021-01-27%2019-46.gif"/>

Detail project bisa dilihat di sourcecode berikut <a href="https://github.com/eljitech/notepadinhand/tree/master/app/notesapp">Disini</a>

### 28 Jan 2021 : Update AdapterDasboard & Implement Icon Category for Notes

<img src="https://github.com/eljitech/notepadinhand/blob/master/pictures/github/Peek%202021-01-28%2009-56.gif"/>

Detail project bisa dilihat di sourcecode berikut <a href="https://github.com/eljitech/notepadinhand/commit/b81035a06f3d9cdc0a140c66c9eac9b6bafdabdb">Disini</a>

### 01 Feb 2021 : Update module list todo, task dan notes, problem solving selesai
* Problem : Ketika menambah data notes dengan kategori tertentu tidak me-ngupdate list : Clear
* Problem : Ketika menghapus pun sama : Clear
* Problem : Program Force close akibat data null, adapter menginformasikan jangan ada data kosong, kecuali terdapat handling di sourcecode : Clear

Result bisa lihat dibawah ini, semua task problem sudah clear dan solve. Silahkan diselesaikan dulu, untuk register dan login akan di report sore hari. Terima kasih

<img src="https://github.com/eljitech/notepadinhand/blob/master/pictures/github/Peek%202021-02-01%2014-56.gif"/>

### 02 Feb 2021 : Adding Module Login with Clear Solvecode from Module Register 
##### Update Mindmap Register access atas Data yang di Tampilkan
* Jika user yang melakukan login kedalam program maka data notes yang ia tambahkan saja yang muncul di program
* Data yang orang lain tambahkan tidak akan muncul seperti berikut output resultnya

<img src="https://github.com/eljitech/notepadinhand/blob/master/pictures/github/Peek%202021-02-02%2014-48.gif"/>

##### Module Register & Login 
* Register encrypt md5 untuk password dan sha1 untuk hash_useraccess
* Login decrypt md5 untuk password dan sha1 untuk hash_useraccess

<img src="https://github.com/eljitech/notepadinhand/blob/master/pictures/github/Peek%202021-02-02%2014-51.gif"/>

Akses kode disini <a href="https://github.com/eljitech/notepadinhand/commit/e67d17b50541fa9d17fdd73256fa88b60cf9f25f"/>

##### Update List filtering berdasarkan Category dan Username akses 

Akses kode disini <a href="https://github.com/eljitech/notepadinhand/blob/edc3cb428fd7d24e4ed3393f1f54ee2c91db4eaa/module/list_notes.php"/>

### Rilis Update : Bisa di download di link berikut
* <a href="https://github.com/eljitech/notepadinhand/releases/tag/150121.2">Pertemuan Terakhir 15 Januari 2021</a> : Update project Native API sudah dapat menampilkan output dari request yang diminta oleh client melalui Postman app. (<i>Unstable</i>)

* <a href="https://github.com/eljitech/notepadinhand/releases/tag/190121.2">Stable Rilis Backend Aplikasi Notes</a> : Ready for develop with client apps. (<b>Stable Now, Download and install in your local server</b>)

### Documentation
* <a href="https://github.com/eljitech/notepadinhand/wiki">Akses Dokumentasi Native API</a> <b>Available</b>
* Dokumentasi Develop & Deployment Apps Android / Website <b>Unavailable</b>

### Remote Status
* This repo is collab with dir.ectsense account
create database sipetor_170914070
use sipetor_170914070

create table golongan(
id_golongan tinyint not null primary key,
nama_golongan varchar(100)
)

create table karyawan(
nik varchar(15) not null primary key,
nama_karyawan varchar(100),
alamat_karyawan text,
email_karyawan text,
id_golongan tinyint foreign key
references golongan(id_golongan) on delete cascade
)

create table login(
nik varchar(15) not null foreign key
references karyawan(nik) on delete cascade,
username varchar(100) not null primary key,
password text not null
)

create table sparepart(
id_sparepart int not null primary key,
nama_sparepart varchar(100),
harga_sparepart int,
stock_sparepart int
)

create table pelanggan(
tnkb_pelanggan varchar(10) not null primary key,
nama_pelanggan varchar(100),
alamat_pelanggan text
)

create table head_trans_penjualan(
id_transaksi varchar(10) not null primary key,
id_karyawan varchar(15) foreign key
references karyawan(nik) on delete cascade,
tnkb_pelanggan varchar(10) foreign key
references pelanggan(tnkb_pelanggan) on delete cascade,
tanggal_transaksi date,
pembayaran int,
sub_total int
)

create table detail_trans_penjualan(
id_reg int not null primary key,
id_transaksi varchar(10) foreign key
references head_trans_penjualan(id_transaksi) on delete cascade,
id_sparepart int foreign key
references sparepart(id_sparepart) on delete cascade,
jumlah_beli int,
total_beli int
)

CREATE PROCEDURE genIDGolongan
AS
BEGIN
	DECLARE @counts int

	SELECT @counts = max(id_golongan) FROM golongan;
	IF(@counts IS NULL)
		SELECT "id_golongan" = 1
	ELSE SELECT "id_golongan" = @counts +1
END

CREATE PROCEDURE genIDSparepart
AS
BEGIN
	DECLARE @counts int

	SELECT @counts = max(id_sparepart) FROM sparepart;
	IF(@counts IS NULL)
		SELECT "id_sparepart" = 1
	ELSE SELECT "id_sparepart" = @counts +1
END

CREATE PROCEDURE [dbo].[genIDTransaksi]
AS
BEGIN
	DECLARE @idtrans varchar(10)
	 DECLARE @counts int
	 DECLARE @dates varchar(6)

	 SELECT @counts = count(*) from head_trans_penjualan WHERE tanggal_transaksi =
		CONVERT(varchar,GETDATE(),23);

	 SET @dates = CONVERT(varchar(6),GETDATE(),12)

	 SET @idtrans = @dates + REPLICATE('0',4 - LEN(@counts)) + CONVERT(varchar(4)
		 ,@counts+1)

	 SELECT "id_transaksi" = @idtrans
END

CREATE PROCEDURE [dbo].[genIDDetail]
AS
BEGIN
	DECLARE @counts int
	
	SELECT @counts = max(id_reg) from detail_trans_penjualan;
	IF (@counts IS NULL) SELECT "id_reg" = 1;
	ELSE SELECT "id_transaksi" = @counts + 1;
END
GO

CREATE PROCEDURE [dbo].[getFaktur]
  @id_transaksi varchar(10)
AS
BEGIN
	SELECT a.*,b.*,c.nama_sparepart,d.nama_karyawan,e.nama_pelanggan
	FROM head_trans_penjualan a
	JOIN detail_trans_penjualan b
	ON a.id_transaksi = b.id_transaksi
	JOIN sparepart c
	ON b.id_sparepart = c.id_sparepart
	JOIN karyawan d
	ON d.nik = a.id_karyawan
	JOIN pelanggan e
	ON e.tnkb_pelanggan = a.tnkb_pelanggan
	WHERE a.id_transaksi = @id_transaksi
END
GO

EXEC dbo.genIDTransaksi
EXEC dbo.genIDDetail
EXEC dbo.getFaktur @id_transaksi=1;

insert into golongan values(1,'Admin'),
(2,'Karyawan'),
(3,'Mekanik'),
(4,'Kasir'),
(5,'Manager'),
(6,'Office Boys'),
(7,'Kurir')

insert into karyawan values
('170914070','Rizki','Cibiru','rizki25@gmail.com',1),
('171015123','Rama','Cileunyi','rama@gmail.com',2),
('190411204','Adi','Arcamanik','adi123@yahoo.com',3),
('201239506','Agus','Antapani','agus123@gmail.com',4),
('783274245','Saya','Bandung','sayasekali@gmail.com',5)

insert into login values
('170914070','admin','rizki225'),
('171015123','rama123','rama123')

insert into sparepart values
(1,'Lampu Depan',10000,50),
(2,'Pelumas',30000,38),
(3,'Brake Fluid',25000,30),
(4,'Ban Tubeless',32000,100),
(5,'Oli Top1',50000,35)

insert into pelanggan values
('B7603OP','Jaret','Jakarta'),
('D5830JU','Adi','Bandung'),
('D7464WS','Panji','Bandung')

select * from login

select * from sparepart

select login.username from karyawan
inner join login on karyawan.nik = login.nik
where username like 'a%'

select * from login where username like 'a%' and password like 'r%'

select * from golongan
select * from karyawan
select * from login
select * from pelanggan
select * from sparepart
select * from head_trans_penjualan
select * from detail_trans_penjualan
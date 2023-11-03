create database QLNT
go
use QLNT
go

create table LoaiNha(
	MaLN nvarChar(10) not null,
	TenLN nvarChar(20) not null
	primary key(MaLN)
)
create table Quan(
	MaQuan nvarChar(10) not null,
	TenQuan nvarChar(20) not null
	primary key(MaQuan)
)
create table NguoiDung(
	MaND nvarChar(10) not null,
	TenND nvarChar(20) not null,
	Gioitinh nvarChar(1) not null,
	DienThoai nvarChar(13) not null,
	DiaChi nvarChar(25) not null,
	MaQuan nvarChar(10) not null,
	Email nvarChar(30) not null,
	primary key(MaND),
	foreign key(MaQuan) references Quan(MaQuan)

)

create table NhaTro(
	MaNhaTro nvarChar(10) not null,
	MaLN nvarChar(10) not null,
	DienTich float not null,
	GiaPhong money not null,
	DiaChi nvarChar(40) not null,
	MaQuan nvarChar(10) not null,
	MoTa nvarChar(30) not null,
	NgayDang date not null,
	NguoiLienHe nvarChar(10) not null,
	primary key(MaNhaTro),
	foreign key(MaLN) references LoaiNha(MaLN),
	foreign key(NguoiLienHe) references NguoiDung(MaND),
	foreign key(MaQuan) references Quan(MaQuan)

)
create table HopDongThue(
	MaND nvarChar(10) not null,
	MaNhaTro nvarChar(10) not null,
	NgayDen date not null,
	NgayDi date null,
	primary key(MaND,MaNhaTro),
	foreign key(MaND) references NguoiDung(MaND),
	foreign key(MaNhaTro) references NhaTro(MaNhaTro)
)
create table DANHGIA(
	MaDG nvarChar(10) not null,
	MaND nvarChar(10) not null,
	MaNhaTro nvarChar(10) not null,
	Likes bit not null,
	NoiDungDanhGia nvarChar(30) null,
	primary key(MaDG),
	foreign key(MaND,MaNhaTro) references HopDongThue(MaND,MaNhaTro)
)

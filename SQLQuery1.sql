create database QLKS
go
use QLKS
go

create table khachhang(
	makh varchar(10) primary key,
	tenkhachhang nvarchar(50) not null,
	matKhau varchar(10) not null,
	sdt varchar(13) not null,
	CMND varchar(12) not null,
	gioitinh int not null check (gioitinh=1 or gioitinh=0 or gioitinh=2),
	-- 1:Nam,0:Nữ,2:Không xác định
	tuoi int not null check (tuoi>=18),
)
create table LoaiPhong(
tenLoaiPhong nvarchar(50) primary key,
	dienTich int not null
)
create table phong(
	maphong varchar(10) primary key not null,
	tenphong nvarchar(50) not null,
	loaiphong nvarchar(50) not null,
	giaphong int not null,
	trangthai int not null check (trangthai=1 or trangthai=0),
	-- 1 phong trong 0 phòng đã có ng ở
	ghichu nvarchar(200)
	foreign key (loaiphong) references LoaiPhong(tenLoaiPhong)
)
create table nhanvien(
	maNv varchar(10) primary key,
	tenNv nvarchar(50) not null,
	chucVu nvarchar(50) not null,
	matKhau varchar(10) not null,
	luong int not null,
	namSinh date not null,
	sdtNv varchar(13) not null,
	gioiTinh int not null check (gioitinh=1 or gioitinh=0 or gioitinh=2),
	-- 1:Nam,0:Nữ,2:Không xác định
	ghiChu nvarchar(200)
)
create table HoaDon(
	maHD varchar(10) ,
	maphong varchar(10) not null,
	makh varchar(10) not null,
	maNv varchar(10) not null,
	donGia int not null,
	soNguoi int not null,
	ngayVao date not null,
	ngayRa date not null,
	thoiGianLapHD smalldatetime not null,
	giamGia int ,
	thanhTien int not null	
	primary key(maHD)
	foreign key (maphong) references phong(maphong),
	foreign key (makh) references khachhang(makh),
	foreign key (maNv) references nhanvien(maNv)
)
drop table HoaDon
create table manager(
	taikhoan varchar(50) primary key,
	matkhau varchar(50) not null
)
INSERT INTO manager (taikhoan, matkhau)
VALUES
('admin', '123456'),
('son', '123456'),
('mai', '123456'),
('long', '123456'),
('chuong', '123456')

-- Thêm dữ liệu cho bảng khachhang
INSERT INTO khachhang (makh, tenkhachhang,matKhau, sdt, CMND, gioitinh, tuoi)
VALUES
('KH003', N'Lê Thị C','123456', '0123456780', '123456789013', 0, 28),
('KH004', N'Hoàng Văn D','123456', '0987654322', '987654321013', 1, 30),
('KH005', N'Nguyễn Thị E','123456', '0123456781', '123456789014', 0, 25),
('KH006', N'Phạm Văn F','123456', '0987654323', '987654321014', 1, 35),
('KH007', N'Trần Văn G','123456', '0123456782', '123456789015', 1, 40),
('KH008', N'Nguyễn Thị H','123456', '0987654324', '987654321015', 0, 22);

-- Thêm dữ liệu cho bảng LoaiPhong
INSERT INTO LoaiPhong (dienTich, tenLoaiPhong)
VALUES
(25, N'Phòng Đơn'),
(40, N'Phòng Đôi'),
(36, N'Phòng Ba'),
(26, N'Phòng Massage'),
(35, N'Phòng Thường'),
(50, N'Phòng Vip');

-- Thêm dữ liệu cho bảng phong
INSERT INTO phong (maphong, tenphong, loaiphong, giaphong, trangthai, ghichu)
VALUES
('P003', N'Phòng 103', N'Phòng Đơn', 1200000, 1, N'Đang có người thuê'),
('P004', N'Phòng 104', N'Phòng Ba', 1100000, 0, N'Phòng trống'),
('P005', N'Phòng 105', N'Phòng Vip', 1300000, 0, N'Phòng trống'),
('P006', N'Phòng 106', N'Phòng Massage', 1400000, 1, N'Đang có người thuê'),
('P007', N'Phòng 107', N'Phòng Vip', 1100000, 0, N'Phòng trống'),
('P008', N'Phòng 108', N'Phòng Thường', 1200000, 1, N'Đang có người thuê');

-- Thêm dữ liệu cho bảng nhanvien
INSERT INTO nhanvien (maNv, tenNv, chucVu,matKhau, luong, namSinh, sdtNv, gioiTinh, ghiChu)
VALUES
('NV003', N'Lê Thị K', N'Nhân viên phục vụ','123456', 7000000, '1993-03-03', '0123456783', 0, N'Nhân viên thử việc'),
('NV004', N'Hoàng Văn L', N'Nhân viên lễ tân','123456', 8000000, '1988-08-08', '0987654325', 1, N'Nhân viên chính thức'),
('NV005', N'Nguyễn Văn M', N'Quản lý phòng','123456', 12000000, '1985-05-05', '0123456784', 1, N'Quản lý phòng ở tầng 2'),
('NV006', N'Phạm Thị N', N'Nhân viên phục vụ','123456', 7500000, '1992-02-02', '0987654326', 0, N'Nhân viên thử việc'),
('NV007', N'Trần Văn P', N'Quản lý phòng','123456', 11000000, '1980-01-01', '0123456785', 1, N'Quản lý phòng ở tầng 1'),
('NV008', N'Nguyễn Thị Q', N'Nhân viên lễ tân','123456', 7800000, '1991-11-11', '0987654327', 0, N'Nhân viên chính thức');

-- Thêm dữ liệu cho bảng HoaDon
INSERT INTO HoaDon (maHD, maphong, makh, maNv, donGia, soNguoi, ngayVao, ngayRa,thoiGianLapHD, giamGia, thanhTien)
VALUES
('HD001', 'P003', 'KH005', 'NV004', 1200000, 2, '2023-11-12', '2023-11-15','2023-11-15 11:34:00', 300000, 2700000),
('HD002', 'P004', 'KH006', 'NV005', 1100000, 1, '2023-11-14', '2023-11-16','2023-11-16 06:40:00', 0, 1100000),
('HD003', 'P005', 'KH004', 'NV005', 1300000, 2, '2023-11-15', '2023-11-17','2023-11-17 18:56:00', 200000, 2800000),
('HD004', 'P006', 'KH003', 'NV007', 1400000, 1, '2023-11-16', '2023-11-19','2023-11-19 16:23:00', 0, 1400000),
('HD005', 'P007', 'KH008', 'NV008', 1100000, 2, '2023-11-17', '2023-11-20','2023-11-20 21:12:00', 250000, 2450000),
('HD006', 'P008', 'KH007', 'NV003', 1200000, 1, '2023-11-18', '2023-11-22','2023-11-22 05:45:00', 0, 1200000);

select maHD, maphong, makh, maNv, donGia, soNguoi, ngayVao, ngayRa,thoiGianLapHD, giamGia, thanhTien from HoaDon
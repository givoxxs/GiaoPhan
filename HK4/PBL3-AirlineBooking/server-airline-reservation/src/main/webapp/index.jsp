<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="includes/header.jsp"%>
</head>
<body>
	<%@include file="includes/navbar.jsp"%>

	<!-- Begin Welcome Page -->
	<div class="trangchu">
		<form name="timchuyenbay" action="#" method="Post">
			<div class="jumbotron text-center trangchu__timkiemchuyenbay">
				<div class="trangchu__slogan row">
					<span class="slogan col-xs-12  col-md-12">"Fly the friendly
						skies"</span> <br> <br> <br> <br> <br> <br>
					<br>
				</div>

				<!-- thanh tìm kiếm chuyến bay-->
				<div class="container">
					<div class="timkiemchuyenbay slideanim row  ">
						<div
							class="timkiemchuyenbay__phantu timkiemchuyenbay--chonThanhPho">
							<i class="fa-solid fa-plane-departure"></i> <input type="text"
								class="timchuyenbay__nhapthanhpho text_demkhoihanh"
								id="diemKhoiHanh_ThanhTimKiem" placeholder="Điểm khởi hành?"
								tabindex="0">
							<div
								class="timkiemchuyenbay__phantu-chonThanhPho timkiemchuyenbay__phantu-chonThanhPho--Diemdi">
								<ul
									class="timkiemchuyenbay__phantu-list timkiemchuyenbay_thanhphodi">

								</ul>
							</div>
						</div>

						<div
							class="timkiemchuyenbay__phantu timkiemchuyenbay--chonThanhPho">
							<i class="fa-solid fa-plane-arrival"></i> <input type="text"
								class="timchuyenbay__nhapthanhpho text_demden"
								id="diemDen_ThanhTimKiem" placeholder="Điểm Đến?">
							<div
								class=" timkiemchuyenbay__phantu-chonThanhPho timkiemchuyenbay__phantu-chonThanhPho--Diemden">
								<ul
									class="timkiemchuyenbay__phantu-list timkiemchuyenbay_thanhphoden">

								</ul>
							</div>
						</div>

						<div class="timkiemchuyenbay__phantu">
							<i class="fa-regular fa-calendar"></i> <input type="text"
								class="btn_lichBay " id="lichBay_ThanhTimKiem"
								readonly="readonly" placeholder="Ngày đi - ngày về">
							<div class="timkiemchuyenbay_phantu__chonlich">
								<div class="timkiemchuyenbay__chonlich">
									<label class="timkiemchuyenbay__chonlich__loaive"
										for="round-trip">Khứ hồi</label> <input
										class="timkiemchuyenbay__chonlich__loaive" type="radio"
										name="loaiVe" value="Khứ hồi" checked="true"
										id="radio_round-trip"> <label
										class="timkiemchuyenbay__chonlich__loaive" for="one-way">Một
										chiều</label> <input class="timkiemchuyenbay__chonlich__loaive"
										type="radio" name="loaiVe" value="Một chiều"
										id="radio_one-way"> <input
										class="chonlich__btnXacnhan" type="button" value="Xác Nhận">
								</div>
								<div class="timkiemchuyenbay__chonlich">
									<label class="timkiemchuyenbay__chonlich-chonngay"
										for="departure-date">Ngày đi:</label> <input
										class="timkiemchuyenbay__chonlich-chonngay" type="date"
										id="departure-date" name="departure-date"
										placeholder="Select Date.." readonly="readonly">
								</div>
								<div
									class="timkiemchuyenbay__chonlich timkiemchuyenbay__chonlich__ngayve">
									<label class="timkiemchuyenbay__chonlich-chonngay"
										for="return-date">Ngày về:</label> <input
										class="timkiemchuyenbay__chonlich-chonngay" type="date"
										id="return-date" name="return-date"
										placeholder="Select Date.." readonly="readonly">
								</div>

							</div>
						</div>

						<div
							class="timkiemchuyenbay__phantu timkiemchuyenbay__phantu--hienThiSoHanhKhach">
							<i class="fa fa-user"></i> <input type="text" class="HienthiSoHK"
								id="soHanhKach_ThanhTimKiemChuyenBay" placeholder="1 Người lớn"
								readonly="readonly"> <input type="hidden"
								id="soHanhKach_nguoilon" value="1"> <input
								type="hidden" id="soHanhKach_treem" value="0">
							<div class="demSoKhachHang">
								<table>
									<div class="nguoiLon">
										<tr>
											<td><span>Người lớn:</span></td>
											<td>
												<button type="button" class="btCountNL">-</button> <span
												class="numberNL">1</span>
												<button type="button" class="btCountNL">+</button>
											</td>
										</tr>
									</div>
									<div class="treEm">
										<tr>
											<td><span>Trẻ em:</span></td>
											<td>
												<button type="button" class="btCountTE">-</button> <span
												class="numberTE">0</span>
												<button type="button" class="btCountTE">+</button>
											</td>
										</tr>
									</div>
									<div class="timchuyenbay__demsohanhkhach__exit exit">
										<i class="fa-regular fa-circle-xmark"></i>
									</div>
								</table>
							</div>
						</div>
						<input type="hidden" id="diemKhoiHanh"> <input
							type="hidden" id="diemden">
						<button type="submit"
							class="timkiemchuyenbay__phantu timkiemchuyenbay__phantu--btnTimChuyenBay"
							onclick="return timkiemchuyenbay('diemKhoiHanh','diemden','departure-date','return-date','radio_round-trip','soHanhKach_nguoilon','soHanhKach_treem','diemKhoiHanh_ThanhTimKiem','diemDen_ThanhTimKiem')">
							Tìm kiếm chuyến bay</button>
					</div>
				</div>
				<!-- /. kết thúc thanh tìm kiếm chuyến bay-->

			</div>
		</form>
	</div>
	<!-- End Welcome Page -->

	<%@include file="includes/footer.jsp"%>
</body>
</html>
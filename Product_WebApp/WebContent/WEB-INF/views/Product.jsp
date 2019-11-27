
<%@page import="com.face.bo.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.face.dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sample Web App</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="Admin_menu.jsp"></jsp:include>
		<div class="container" align="center"
			style="margin-top: 3em; min-height: 200%;">
		
			
			<%
				if (request.getAttribute("data") != null) {
					Product pd = (Product) request.getAttribute("data");
			%>

			<form action="${pageContext.request.contextPath }/ProductUpdate"
				method="post" style="width: 50%;">
				<div class="form-group row">
					<label for="inputEmail3" class="col-sm-2 col-form-label">Product</label>
					<div class="col-sm-10">
						<input type="text" autocomplete="off" autofocus="autofocus"
							value="<%=pd.getPname()%>" name="pname" class="form-control"
							id="inputEmail3" placeholder="Product Name">
					</div>
				</div>
				<div class="form-group row">
					<label for="inputEmail3" class="col-sm-2 col-form-label">Quantity</label>
					<div class="col-sm-4">
						<input type="number" name="qty" value="<%=pd.getQty()%>"
							class="form-control" id="inputEmail3" placeholder="0">
					</div>
					<label for="inputEmail3" class="col-sm-2 col-form-label">Price</label>
					<div class="col-sm-4">
						<input type="number" name="price" value="<%=pd.getPrice()%>"
							class="form-control" id="inputEmail3" placeholder="0"> <input
							type="text" hidden="hidden" value="up" name="update"> <input
							type="text" hidden="hidden" value="<%=pd.getPid()%>" name="pid">
					</div>
				</div>

				</br> </br>

				<div class="form-group row">
					<div class="col-sm-10">

						<button type="submit" class="btn btn-primary">Update</button>

						<a href="${pageContext.request.contextPath}/">Cancel</a>
					</div>
				</div>
			</form>
			<%
				} else {
			%>
			<div class="card bg-light mb-5" style="max-width: 80rem;">
				<div class="card-header">	<% if(request.getAttribute("errorString")!=null){ %><div class="alert alert-success" role="alert">
 <p style="color:green;">${errorString}</p>
</div><%} %></div>
				<div class="card-body">
					<form action="${pageContext.request.contextPath }/AddProduct"
						method="post" style="width: 50%;">
						<div class="form-group row">
							<label for="inputEmail3" class="col-sm-2 col-form-label">Product</label>
							<div class="col-sm-9">
								<input type="text" autocomplete="off" autofocus="autofocus"
									value="" name="pname" class="form-control" id="inputEmail3"
									placeholder="Product Name">
							</div>
						</div>
						<div class="form-group row">
							<label for="inputEmail3" class="col-sm-2 col-form-label">Quantity</label>
							<div class="col-sm-4">
								<input type="number" name="qty" value="" class="form-control"
									id="inputEmail3" placeholder="0">
							</div>
							<label for="inputEmail3" class="col-sm-2 col-form-label">Price</label>
							<div class="col-sm-4">
								<input type="number" name="price" value="" class="form-control"
									id="inputEmail3" placeholder="0">
							</div>
						</div>


						<div class="form-group row">
							<div class="col-sm-10">

								<button type="submit" class="btn btn-primary">Add  </button>

								<a href="${pageContext.request.contextPath}/">
									<button type="submit" class="btn btn-danger">Cancel</button>
								</a>
							</div>
						</div>
					</form>

				</div>
			</div>

			<%
				}
			%>
			<%
				ArrayList<Product> p = (ArrayList<Product>) request.getAttribute("product");
			%>

			<div class="table-responsive-md">

				<table class="table table-hover">
					<thead class="thead-gray">
						<tr>
							<th scope="col">#</th>
							<th scope="col">NAme</th>
							<th scope="col">Qty</th>
							<th scope="col">Price</th>
							<th scope="col">Edit</th>
							<th scope="col">Delete</th>
						</tr>
					</thead>


					<tbody>
						<%
							for (Product ps : p) {
						%>
						<tr>

							<th scope="row"><%=ps.getPid()%></th>
							<td><%=ps.getPname()%></td>
							<td><%=ps.getQty()%></td>
							<td><%=ps.getPrice()%></td>

							<form action="${pageContext.request.contextPath }/ProductEdit"
								method="post">
								<input type="text" hidden="hidden" name="edit"
									value=" <%=ps.getPid()%>">
								<td><i class="material-icons"><input
										class="btn btn-link" type="Submit" value="&#xe22b;"></i></td>
							</form>
							<form action="${pageContext.request.contextPath }/ProductDelete"
								method="post">
								<input type="text" hidden="hidden" name="delete"
									value=" <%=ps.getPid()%>">
								<td><i class="material-icons"><input
										class="btn btn-danger" type="Submit" value="&#xe872;"></i></td>
							</form>
						</tr>
						<%} %>
					</tbody>
				</table>

			</div>



		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>
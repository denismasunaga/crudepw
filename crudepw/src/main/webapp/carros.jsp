<!DOCTYPE html>
<%@page import="model.Carro"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>Cadastro de Carros</title>
<meta charset="utf-8">
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body style="margin-top: 15px">
  <div class="container">
    <div class="row">
      <div class="col-md-offset-2 col-md-8">
        <ol class="breadcrumb">
          <li><a href="/">Menu</a></li>
          <li class="active">Venda</li>
        </ol>
        <div class="panel panel-default">
          <div class="panel-body">
            <form method = "POST" action="/crudepw/carro">
              <div class="form-group">
                <input
                  name="codigo"
                  <%-- value="${param.codigo}" --%>
                  type="number"
                  placeholder="Codigo"
                  class="form-control">
              </div>
              <div class="form-group">
                <input
                  name="modelo"
                  <%-- value="${param.modelo}" --%>
                  type="text"
                  placeholder="Modelo"
                  class="form-control">
              </div>
              <div class="form-group">
                <input
                  name="cor"
                  <%-- value="${param.cor}" --%>
                  type="text"
                  placeholder="Cor"
                  class="form-control">
              </div>
              <div class="form-group">
                <input
                  name="fabricante"
                  <%-- value="${param.fabricante}" --%>
                  type="text"
                  placeholder="Fabricante"
                  class="form-control">
              </div>
              <div class="form-group">
                <input
                  name="ano"
                  <%-- value="${param.ano}" --%>
                  type="number"
                  placeholder="Ano"
                  class="form-control">
              </div>
              <input type= "submit" value="Inserir" class="btn btn-default" />
              <button name="op" value="update" class="btn btn-default">Salvar</button>
              <button name="op" value="delete" class="btn btn-default">Excluir</button>
            </form>
          </div>
        </div>
        <table class="table table-bordered table-striped">
          <tr>
            <td>Codigo</td>
            <td>Produto</td>
            <td>Quantidade</td>
            <td>#</td>
          </tr>
          <%
          List<Carro> carros = (List<Carro>) request.getAttribute("carros");
          if(carros != null){
	          for (Carro c:carros) {
	          %>
	            <tr>
	              <td><a href="venda?codigo=<%=c.getCodigo()%>&modelo=<%=c.getModelo()%>
	              &cor=<%=c.getCor()%>&fabricante=<%=c.getFabricante()%>&ano=<%=c.getAno()%>"><%=c.getCodigo()%></a></td>
	              <td><%=c.getModelo()%></td>
	              <td><%=c.getFabricante()%></td>
	
	            </tr>
	          <%
          	}
          }
          %>
        </table>
      </div>
    </div>
  </div>
</body>
</html>
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
        </ol>
        <div class="panel panel-default">
          <div class="panel-body">
            <form method = "POST" action="/crudepw/carro">
              <div class="form-group">
                <input
                  name="codigo"
                  type="number"
                  placeholder="Codigo"
                  class="form-control">
              </div>
              <div class="form-group">
                <input
                  name="modelo"
                  type="text"
                  placeholder="Modelo"
                  class="form-control">
              </div>
              <div class="form-group">
                <input
                  name="cor"
                  type="text"
                  placeholder="Cor"
                  class="form-control">
              </div>
              <div class="form-group">
                <input
                  name="fabricante"
                  type="text"
                  placeholder="Fabricante"
                  class="form-control">
              </div>
              <div class="form-group">
                <input
                  name="ano"
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
            <td>Deletar</td>
            <td>Modelo</td>
            <td>Cor</td>
            <td>Fabricante</td>
            <td>Ano</td>
            
          </tr>
          <%
          List<Carro> carros = (List<Carro>) request.getAttribute("carros");
          if(carros != null){
	          for (Carro c:carros) {
	          %>
	            <tr>
	              <td><a href="carro-delete?id=<%=c.getCodigo()%>"><%=c.getCodigo()%></a></td>
	              <td><%=c.getModelo()%></td>
	              <td><%=c.getCor()%></td>
	              <td><%=c.getFabricante()%></td>
	              <td><%=c.getAno()%></td>
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
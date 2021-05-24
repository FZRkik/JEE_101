<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
@import url(https://fonts.googleapis.com/css?family=Open+Sans);

body{
  background: #f2f2f2;
  font-family: 'Open Sans', sans-serif;
}

.search {
  width: 100%;
  position: relative;
  display: flex;
}

.searchTerm {
  width: 100%;
  border: 3px solid #00B4CC;
  border-right: none;
  padding: 5px;
  height: 20px;
  border-radius: 5px 0 0 5px;
  outline: none;
  color: #9DBFAF;
}

.searchTerm:focus{
  color: #00B4CC;
}

.selectButton {
  width: 220px;
  height: 36px;
  border: 1px solid #00B4CC;
  background: #00B4CC;
  text-align: center;
  color: #fff;
  border-radius: 0 5px 5px 0;
  cursor: pointer;
  font-size: 15px;
}

/*Resize the wrap to see the search bar change!*/
.wrap{
  width: 50%;
  position: absolute;
  top: 30%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.button {
  background-color: #00B4CC; 
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: block;
  font-size: 10px;
  border-radius:20% ;
  float:center;
}


</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="wrap">
   <form  class="search" action="AccessLivre" method="get">
    
      <input type="text"  name="recherche" class="searchTerm" placeholder="chercher un livre ">
      <select class="selectButton" name="type_rech" >
      <option selected>Rechercher par:</option>
      <option >Auteur</option>
      <option  >Catégorie</option>
      </select>
      <button type="submit"class="button"  >Recherche</button>
      
      
   </form>
</div>
  
</body>
</html>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<html>
<body>
  <h1>Book edit form</h1>
  <c:if test = "${book.readAlready==false}">
  <a href="<c:url value="read-book"><c:param name="id" value="${book.id}"/></c:url>">Take book to read</a></td>
</c:if>
<form:form action="save-book" method="post" modelAttribute="book">

<table>
  <tr>
    <td>Id</td>
    <td>
      <c:out value="${book.id}"/>
      <form:hidden path="id"/>
    </td>
  </tr>
  <tr>
    <td>Title</td>
    <td>
      <form:input path="title"/>
      <form:errors path="title"/>
    </td>
  </tr>
  <tr>
   <td>Description</td>
   <td>
     <form:input path="description"/>
     <form:errors path="description"/>
   </td>
 </tr>
 <tr>
   <td>Author</td>
   <td>
     <c:out value="${book.author}"/>
     <form:hidden path="author" />
   </td>
 </tr>
 <tr>
   <td>ISBN</td>
   <td>
     <form:input path="isbn"/>
     <form:errors path="isbn"/>
   </td>
 </tr>
 <tr>
   <td>Year</td>
   <td>
     <form:input path="printYear"/>
     <form:errors path="printYear"/>
   </td>
 </tr>
 <tr>
  <td>Was read</td>
  <td>
    <form:checkbox path="readAlready" disabled="true"/>
  </td>
</tr>

</table>
<input type="submit" value="Save"/>
</form:form>

<a href="<c:url value="delete-book"><c:param name="id" value="${book.id}"/></c:url>">Delete book</a></td>
</body>

</html>

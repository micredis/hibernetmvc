<%@ include file="/WEB-INF/jsp/include.jsp" %>
<html>
<body>
  <h1>Creating book</h1>
  <form:form action="save-book" method="post" modelAttribute="book" acceptCharset="UTF-8">
  <table>
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
       <form:input path="author"/>
       <form:errors path="author"/>
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

 </table>
 <input type="submit" value="Save"/>
</form:form>
</body>

</html>

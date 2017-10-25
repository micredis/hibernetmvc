<%@ include file="/WEB-INF/jsp/include.jsp" %>
<html>
<head><title>Index</title></head>
<body>
  <h1>Books</h1>

  <a href="create-book">Add book</a>
  <form action="search">
    <label for="title">Enter title to search</label>
    <input type=text name="title" value="<c:out value="${title}"/>"/>
  </form>

  <table>
    <tr>
      <th>Id</th>
      <th>Title</th>
      <th>Description</th>
      <th>Author</th>
      <th>ISBN</th>
      <th>Year</th>
      <th>Already read</ th>
      </tr>
      <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.id}"/></td>
            <td><a href="<c:url value="edit-book"><c:param name="id" value="${book.id}"/></c:url>"><c:out value="${book.title}"/></a></td>
            <td><c:out value="${book.description}"/></td>
            <td><c:out value="${book.author}"/></td>
            <td><c:out value="${book.isbn}"/></td>
            <td><c:out value="${book.printYear}"/></td>
            <td><c:out value="${book.readAlready ? 'Yes' : 'No'}"/></td>
        </tr>
      </c:forEach>
     <tr>
      <td colspan="4" align="center">
        <c:if test="${before!=null}">
        <a href="?before=<c:out value="${before}"/>">previous</a>
        </c:if>
      </td>
      <td colspan="3" align="center">
        <c:if test="${from!=null}">
        <a href="?from=<c:out value="${from}"/>">next</a>
        </c:if>
      </td>
    </tr>
  </table>
</body>
</html>
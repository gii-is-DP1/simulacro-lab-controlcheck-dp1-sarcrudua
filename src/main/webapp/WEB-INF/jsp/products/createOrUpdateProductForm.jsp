<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
   
<petclinic:layout pageName="Product">
        <jsp:body>
            <h2>
                <c:if test="${product['new']}">New </c:if> Product
            </h2>
            <form:form modelAttribute="product" class="form-horizontal" >
                <div class="form-group has-feedback">
                    <petclinic:inputField label="Name" name="name"/>
                    <petclinic:inputField label="Price" name="price"/>
                    <petclinic:selectField name="productType" label="Product Type" names="${product_types}" size="5"/>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input type="hidden" name="id" value="${product.id}"/>
                        <button class="btn btn-default" type="submit">Save product</button>
                    </div>
                </div>
            </form:form>
        </jsp:body>
</petclinic:layout>
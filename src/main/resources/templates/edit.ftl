<#import "parts/common.ftl" as c>

<@c.page>

<div>
    <h2>Редактировать</h2>
    <form action ="/update/${product.getId()}" method="post"  enctype="multipart/form-data">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <table border="0" cellpadding="10">
            <tr>
                <td>Производитель:</td>
                <td><input type="text" name="manufacturer" value="${product.manufacturer}"/></td>
            </tr>
            <tr>
                <td>Модель:</td>
                <td><input type="text" name="model" value="${product.model}"/></td>
            </tr>
            <tr>
                <td>Цена товара:</td>
                <td><input type="number" name="price" value="${product.price}"/></td>
            </tr>
            <tr>
                <td>Изображение:</td>
                <td><input type="file" name="file" value="${product.fileName}"/></td>
            </tr>
            <tr>
                <td> Описание:</td>
                <td><input type="text"  name="description" ${product.description}/></td>
            </tr>
            <tr>
                <td> Колличество:</td>
                <td><input type="number" name="amount" value="${product.amount}"/></td>
            </tr>
            <tr>
                <td>Тип товара:</td>
                <td><input type="text" name="productTypes" value="${product.productTypes}"/></td>
            </tr>
            <tr>
                <td colspan="2"><button type="submit">Сохранить</button></td>
            </tr>
        </table>
    </form>
</div>

</@c.page>
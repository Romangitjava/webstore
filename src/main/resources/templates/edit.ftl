<#import "parts/common.ftl" as c>

<@c.page>

<div>
    <h2>Редактировать</h2>
    <form action ="edit/${product.id}"  enctype="multipart/form-data">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <table border="0" cellpadding="10">
            <tr>
                <td>Производитель:</td>
                <td><input type="text" name="manufacturer"/></td>
            </tr>
            <tr>
                <td>Модель:</td>
                <td><input type="text" name="model"/></td>
            </tr>
            <tr>
                <td>Цена товара:</td>
                <td><input type="text" name="price"/></td>
            </tr>
            <tr>
                <td>Изображение:</td>
                <td><input type="file" name="file"/></td>
            </tr>
            <tr>
                <td> Описание:</td>
                <td><input type="text" name="description"/></td>
            </tr>
            <tr>
                <td> Колличество:</td>
                <td><input type="text" name="amount"/></td>
            </tr>
            <tr>
                <td>Тип товара:</td>
                <td><input type="text" name="productTypes"/></td>
            </tr>
            <tr>
                <td colspan="2"><button type="submit">Сохранить</button></td>
            </tr>
        </table>
    </form>
</div>

</@c.page>
<!DOCTYPE html>
<html>
<head>
    <title>BUYSELL</title>
</head>
<body>
    <h1>BUYSELL</h1>
    <h4>Подробная информация о товаре</h4>
    <#list images as img>
        <img src="/images/${img.id}" height="60px" alt=''/><br><br>
    </#list>
    <b>Название товара: </b>${product.title}        <br>
    <b>Описание:        </b>${product.description}  <br>
    <b>Цена:            </b>${product.price}        <br>
    <b>Город:           </b>${product.city}         <br>
    <b>Автор:           </b>${product.author}       <br>
    <hr>
    <form action="/product/delete/${product.id}" method="post">
        <input type="submit" value="Удалить товар"/>
    </form>
</body>
</html>
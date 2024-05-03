<!DOCTYPE html>
<html>
    <head>
        <title>BUYSELL</title>
    </head>
    <body>
        <h1>BUYSELL</h1>
        <h4>Подробная информация</h4>
        <b>Название товара: </b>${event.title}        <br>
        <b>Описание:        </b>${event.description}  <br>
        <b>Дата:            </b>${event.date}         <br>
        <b>Место:           </b>${event.place}         <br>
        <hr>
        <form action="/event/delete/${event.id}" method="post">
            <input type="submit" value="Удалить событие"/>
        </form>
    </body>
</html>
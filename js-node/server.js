const express = require('express');
const app = express();
const port = 3000;

app.get('/', (req, res) => {
    res.sendFile(__dirname + "/" + "home.html");
});

app.get('/produto', (req, res) => {
    res.sendFile(__dirname + "/" + "produto.html");
});

app.post('/produto', (req, res) => {
    res.send('<h1>Produto cadastrado.</h1><a href="/">Voltar para home</a>')
});

app.listen(port, () => {
    console.log('Servidor rodando em http://localhost:${port}')
    console.log('Para derrubar o servidor: ctrl + c');
});
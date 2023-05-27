const express = require('express');
const path = require('path');
const app = express();
const port = process.env.port || 8080;

const customHeadersAppLevel = (_req, res, next) => {
    res.setHeader('X-Powered-By', 'Custom Express Header')
    next();
};

app.use(customHeadersAppLevel)
app.use(express.static(path.join(__dirname, './frontend/build')));
app.get('*', (_req, res) => {
    res.set('Foo', 'bar');
    res.sendFile(path.join(__dirname, './frontend/build/index.html'));
});

app.listen(port, () => {
    console.log(`App listening on port ${port}`);
});
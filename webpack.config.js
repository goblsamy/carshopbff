const path = require('path');

const merge = require('webpack-merge');
const flowDefaults = require('./webpack.generated.js');

module.exports = merge(flowDefaults, {
    mode: 'development', // Fejlesztési mód beállítása
    devtool: 'inline-source-map', // Forráskód hibakeresésének megkönnyítése
    devServer: {
        contentBase: path.join(__dirname, 'dist'), // A kiszolgálásra szánt fájlok elérési útvonala
        compress: true, // Fájlok tömörítése (opcionális)
        port: 9000 // A szerver portja (opcionális, alapértelmezett: 8080)
    }
});

module.exports = {
    outputDir: '../../src/main/java/webapp/public',
    pages: {
        customer: {
            entry: './src/entries/customer/customer.js',
            template: './public/customer.html',
            title: '恰饭外卖',
            chunks: ['chunk-vendors', 'chunk-common', 'customer']
        }
    },
    productionSourceMap: true,
    devServer:{
        headers:{
            "Expires": 0
            //"Cache-Control": "no-cache"
        }
    }
}
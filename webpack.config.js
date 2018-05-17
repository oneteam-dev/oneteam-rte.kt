/* eslint-env node */
const webpack = require('webpack');
const path = require('path');
const bootstrap = require('bootstrap-styl');

const entry = ['@babel/polyfill', './js/index.js'];
const plugins = [
  new webpack.LoaderOptionsPlugin({
    test: /\.styl$/,
    stylus: { default: { use: [bootstrap()] } }
  }),
  new webpack.DefinePlugin({
    'process.env': {
      NODE_ENV: JSON.stringify('production')
    }
  }),
  new webpack.optimize.UglifyJsPlugin()
];

module.exports = {
  plugins,
  entry,
  cache: true,
  output: {
    path: path.resolve(__dirname, 'js/'),
    filename: 'bundle.js'
  },
  module: {
    rules: [
      {
        test: /\.js$/,
        exclude: /node_modules/,
        use: ['babel-loader']
      },
      {
        test: /\.css$/,
        use: ['style-loader', 'css-loader']
      },
      {
        test: /\.styl$/,
        use: ['style-loader', 'css-loader', 'stylus-loader']
      },
      {
        test: /\.woff(2)?(\?v=[0-9]\.[0-9]\.[0-9])?$/,
        loader: 'url-loader',
        options: { mimetype: 'application/font-woff' }
      },
      {
        test: /\.(ttf|eot|svg)(\?v=[0-9]\.[0-9]\.[0-9])?$/,
        loader: 'url-loader'
      },
      {
        test: /\.png$/,
        loader: 'url-loader'
      }
    ]
  }
};

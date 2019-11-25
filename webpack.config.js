/* eslint-env node */
const webpack = require('webpack');
const path = require('path');
const bootstrap = require('bootstrap-styl');
const UglifyJSPlugin = require('uglifyjs-webpack-plugin');

const entry = './js/index.js';
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
  new UglifyJSPlugin()
];

module.exports = {
  plugins,
  entry,
  cache: true,
  mode: 'production',
  output: {
    path: path.resolve(__dirname, 'js/'),
    filename: 'bundle.js'
  },
  module: {
    rules: [
      {
        test: /\.js$/,
        exclude: /node_modules/,
        use: {
          loader: 'babel-loader',
          options: {
            presets: ['@babel/preset-env']
          }
        }
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

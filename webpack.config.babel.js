/* eslint-env node */
import webpack from 'webpack';
import path from 'path';
import bootstrap from 'bootstrap-styl';

const entry = ['babel-polyfill', './js/index.js'];
const plugins = [
  new webpack.LoaderOptionsPlugin({
    test: /\.styl$/,
    stylus: { default: { use: [bootstrap()] } }
  })
];

export default {
  plugins,
  entry,
  cache: true,
  output: {
    path: path.resolve(__dirname, 'core/src/main/assets'),
    filename: 'bundle.js'
  },
  resolve: {
    extensions: ['.js']
  },
  module: {
    loaders: [
      {
        test: /\.js$/,
        exclude: /node_modules/,
        loader: 'babel-loader',
        query: { presets: ['es2015', 'react'] }
      },
      {
        test: /\.css$/,
        loaders: ['style-loader', 'css-loader']
      },
      {
        test: /\.styl$/,
        loaders: ['style-loader', 'css-loader', 'stylus-loader']
      }
    ]
  }
};

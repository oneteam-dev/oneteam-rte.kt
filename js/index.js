import React from 'react';
import ReactDOM from 'react-dom';
import Editor from './editor';
import './index.styl';
import './content.styl';

ReactDOM.render((
    <Editor ref={c => window.editor = c} />
), document.getElementById('app-root'));

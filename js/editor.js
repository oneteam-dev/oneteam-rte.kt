import React, { Component } from 'react';
import RichTextEditor from 'oneteam-rte';

export default class Editor extends Component {
    constructor(props) {
        super(props);
        this.editor = null;
        this.state = { editorState: {}, paddingTop: 0 };
    }
    set paddingTop(paddingTop) {
        this.setState({ paddingTop });
    }
    get paddingTop() {
        return this.state.paddingTop;
    }
    set placeholder(value) {
        this.setState({ placeholder: value });
    }
    get placeholder() {
        return this.state.placeholder || RichTextEditor.defaultProps.placeholder;
    }
    setEditor(editor) {
        this.editor = editor;
    }
    focus() {
        if(this.editor) {
            this.editor.focus();
        }
    }
    blur() {
        if(this.editor) {
            this.editor.blur();
        }
    }
    insertImage(...args) {
        if(this.editor) {
            this.editor._insertImage(...args);
        }
    }
    insertDownloadLink(...args) {
        if(this.editor) {
            this.editor._insertDownloadLink(...args);
        }
    }
    insertIFrame(iframeTag) {
        if(this.editor) {
            this.editor._insertIFrame(iframeTag); // FIXME: DO NOT call private method
        }
    }
    toggleLink(url = null) {
        if(this.editor) {
          this.editor.toggleLink(url);
        }
    }
    toggleBlockType(type) {
        if(this.editor) {
            this.editor.toggleBlockType(type);
        }
    }
    toggleInlineStyle(style) {
        if(this.editor) {
            this.editor.toggleInlineStyle(style);
        }
    }
    getCurrentInlineStyles() {
        if(this.editor) {
            return this.editor.getCurrentInlineStyles();
        }
        return [];
    }
    getCurrentBlockType() {
        if(this.editor) {
            return this.editor.getCurrentBlockType();
        }
        return "";
    }
    getHTML() {
        if(this.editor) {
          return this.editor.html;
        }
        return "";
    }
    setHTML(html) {
        if(this.editor) {
          this.editor.html = html;
        }
    }
    setCallbackToken(callbackToken) {
        this.setState({callbackToken});
        AndroidInterface.setCallbackToken(callbackToken);
    }
    triggerOnChange() {
        const data = {
            inlineStyles: this.getCurrentInlineStyles(),
            blockType: this.getCurrentBlockType(),
            html: this.editor.html
        };
        AndroidInterface.didChangeEditorState(data);
    }
    render() {
        return (
            <div style={{ paddingTop: this.state.paddingTop }}>
              <RichTextEditor
                  onChange={() => { this.triggerOnChange() }}
                  ref={(c) => this.setEditor(c)} />
            </div>
        )
    }
}

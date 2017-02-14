import React, { Component } from 'react';
import RichTextEditor from 'oneteam-rte';

const FileLink = props => {
  return <div>
      <a href={props.blockProps.url}>
          {props.blockProps.name}
      </a>
  </div>;
};

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
            this.editor.insertImageAtomicBlock(...args);
        }
    }
    insertDownloadLink(...args) {
        if(this.editor) {
            this.editor.insertAtomicBlock('FILE_PLACEHOLDER', 'IMMUTABLE', ...args);
        }
    }
    insertIFrame(tag) {
        if(this.editor) {
            this.editor.insertIFrameAtomicBlock(tag);
        }
    }
    toggleLink(url = null) {
        if(this.editor) {
          this.editor.toggleLink(url);
          AndroidInterface.didChangeInlineStyles(this.getCurrentInlineStyles().join(','));
        }
    }
    toggleBlockType(type) {
        if(this.editor) {
            this.editor.toggleBlockType(type);
            AndroidInterface.didChangeBlockType(this.getCurrentBlockType());
        }
    }
    toggleInlineStyle(style) {
        if(this.editor) {
            this.editor.toggleInlineStyle(style);
            AndroidInterface.didChangeInlineStyles(this.getCurrentInlineStyles().join(','));
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
    triggerOnChange() {
        AndroidInterface.didChangeInlineStyles(this.getCurrentInlineStyles().join(','));
        AndroidInterface.didChangeBlockType(this.getCurrentBlockType());
        AndroidInterface.didChangeContent(this.editor.html);
    }
    render() {
        return (
            <div style={{ paddingTop: this.state.paddingTop }}>
              <RichTextEditor
                  onChange={() => { this.triggerOnChange() }}
                  atomicBlockRenderMap={{["FILE_PLACEHOLDER"]: FileLink}}
                  ref={(c) => this.setEditor(c)} />
            </div>
        )
    }
}

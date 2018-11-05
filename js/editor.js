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
        this.state = { editorState: {}, paddingTop: 0, rawMentions:[] };
    }
    componentDidMount() {
        AndroidInterface.didMountComponent();
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
    set rawMentions(rawMentions) {
        this.setState({ rawMentions });
    }
    get rawMentions() {
        return this.state.rawMentions;
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
            this.editor.insertAtomicBlock('IMAGE', 'IMMUTABLE', ...args);
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
        setTimeout(() => { this.editor.focus(); }, 0);
    }
    /* sample data for rawMentions
    dummyRawMentions() {
        return [
                 {
                   id: 1,
                   userName: "yamamoto",
                   name:"yamamoto",
                   email:"aaa",
                   avatarURL: "https://github.com/oneteam-dev/react-oneteam/commits/f54df7e2d0dbab1a6fe49f62987e23a19bf01d61/src/Mention/index.js?author=sugarshin"
                 }
               ]
    }*/
    render() {
        return (
            <div style={{ paddingTop: this.state.paddingTop }}>
              <RichTextEditor
                  rawMentions={ this.state.rawMentions }
                  onChange={() => { this.triggerOnChange() }}
                  placeholder=''
                  atomicBlockRenderMap={{["FILE_PLACEHOLDER"]: FileLink}}
                  onKeyDown={this.handleKeyDown}
                  ref={(c) => this.setEditor(c)} />
            </div>
        )
    }
}

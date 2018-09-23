import React from 'react'
import 'bootstrap-css-only'
import Body from './Body';
import './styles.css'


class Layout extends React.PureComponent {
  render() {
    return (
      <>
        <Body />
        <div>{this.props.children}</div>
      </>
    )
  }
}

export default Layout

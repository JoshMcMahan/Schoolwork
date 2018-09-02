import React from 'react'
import 'bootstrap-css-only'
import Header from '../components/Header'

class Layout extends React.PureComponent {
  render() {
    return (
      <>
        <Header />
        <div>{this.props.children}</div>
      </>
    )
  }
}

export default Layout

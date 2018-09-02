import React from 'react'

class Layout extends React.PureComponent{

  render() {
    return (
      <div>{this.props.children}</div>
    )
  }
}

export default Layout

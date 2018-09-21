import React from 'react'
import 'bootstrap-css-only'
import styled from 'styled-components'
import Body from './Body';
import Background from '../images/mountain.jpeg'

var Img = styled.img`
z-index: -1;
transform: translate(0%,0%);
width: 100%;


`
class Layout extends React.PureComponent {
  render() {
    return (
      <>
        
        <Img src={Background} alt="profile picture" />
        <Body />
        <div>{this.props.children}</div>
      </>
    )
  }
}

export default Layout

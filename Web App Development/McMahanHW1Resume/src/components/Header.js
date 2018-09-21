import React from 'react'
import styled from 'styled-components'



const spacer = '1rem'
const Nav = styled.nav`

  border-color:transparent;
  
  
  li {
    margin-left: 20px;
    margin-right: 20px;
    font-size: 1.5rem;
   }
`

class Header extends React.PureComponent {
  render() {
    return (
      <Nav className="navbar navbar-expand-lg navbar-light navbar-light">
        <button
          className="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon" />
        </button>

        <div className="collapse navbar-collapse" id="navbarSupportedContent">
          <ul className="navbar-nav ml-auto">
            <li className="nav-item active">
              <a className="nav-link" href="">
                About <span className="sr-only">(current)</span>
              </a>
            </li>
            <li className="nav-item">
            <a href="Skills">
                Skills
              </a>
            </li>
            <li className="nav-item">
              <a className="nav-link disabled" href="#">
                Portfolio
              </a>
            </li>
            <li className="nav-item">
              <a className="nav-link disabled" href="#">
                Calendar
              </a>
            </li>
          </ul>
        </div>
      </Nav>
    )
  }
}

export default Header

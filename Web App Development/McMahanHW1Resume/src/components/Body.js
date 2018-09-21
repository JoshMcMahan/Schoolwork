import React from 'react'
import styled from 'styled-components'
import profile from '../images/me.jpg'
import Linkedin from '../images/logo.ico'
import Github from '../images/black.ico'
import Facebook from '../images/facebook.ico'

const Wrapper = styled.div`
  background-color: lightgray;
`

const Footer = styled.div`
  display: inline-block;
  padding-bottom: 1rem;
  img {
    height: 40px;
    width: 40px;
  }
`

const ProfilePic = styled.img`
  max-width: 280px;
`

class Body extends React.PureComponent {
  render() {
    return (
      <Wrapper className="container">
        <div className="row">
          <div className="col-12 col-md-4">
            <ProfilePic className="img-fluid mb-1 mb-md-4" src={profile} alt="profile" />
          </div>
          <div className="col text-left text-md-center">
            <h1 >Hello</h1>
            <h2>Im Josh McMahan</h2>
            <h6>Age: 27</h6>
            <h6>
              <a href="mailto:joshua.mcmahan@okstate.edu">
                Joshua.McMahan@okstate.edu
              </a>
            </h6>
            <h6>phone#: (918) 555-8156</h6>
            <h6>Occupation: Student</h6>
          </div>
        </div>
        <div className="row">
          <div className="col">
            <h2>About me:</h2>
            <p>
              I am current attending Oklahoma State University seeking a
              bacholers degree in Computer Science. I am in my senior year and
              plan to gradute in May of 2019. Once I gradute I wish to work as a
              software developer. I have a pation for technology and will
              continue to challenging myself while learning new and better ways
              to code.
            </p>

            <h2>Experience:</h2>
            <p>
              Since I am still a student I dont have a ton of experience, but I
              have worked on some pretty interesting projects over the last few
              years. I made a Minesweeper game, built web applications, mobile
              applications, and done some work with robot vision.
            </p>
            <h2>Skills:</h2>
            <p>
              I am hardworking, dedicated, able to work well on my own or in a
              group enviroment. I am effeciant in many different programming
              languages such as Java, python, C++, C, Javascript, and Swift.
            </p>
          </div>
        </div>

        <Footer>
          <a href="https://github.com/JoshMcMahan">
            <img className="img-fluid" src={Github} alt="github icon" />
          </a>
          <a href="https://www.facebook.com/dmc2036?ref=bookmarks">
            <img className="img-fluid" src={Facebook} alt="facebook icon" />
          </a>
          <a href="https://www.linkedin.com/in/joshua-mcmahan-324182157/">
            <img className="img-fluid" src={Linkedin} alt="linkedin icon" />
          </a>
        </Footer>
      </Wrapper>
    )
  }
}

export default Body

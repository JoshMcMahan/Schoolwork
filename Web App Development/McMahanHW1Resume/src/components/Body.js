import React from 'react'
import styled from 'styled-components'
import profile from '../images/me.jpg'
import Linkedin from '../images/logo.ico'
import Github from '../images/black.ico'
import Facebook from '../images/facebook.ico'

var Div = styled.div`
  transform: translate(25%, -122%);
  width: 1100px;
  height: 900px;
  z-index: -1;
  background-color: lightgray;
`

var Img = styled.img`
  transform: translateY(50);
  width: 200px;
  height: 200px;
  padding: 10px;
  border-radius: 20%;
`
var Img2 = styled.img`
  transform: translate(770%, -320%);
  width: 100px;
  height: 100px;
  padding: 5px;
  display: inline-block;
`

var H1 = styled.h1`
  transform: translate(20%, -350%);
  padding-top: 10px;
`

var H2 = styled.h2`
  transform: translate(20%, -500%);
`

var H3 = styled.h3`
  transform: translate(55%, -800%);
  padding-top: 5px;
`
var P = styled.p`
  transform: translate(10%, -200%);
  width: 90%;
  margin-right: 0px;
  font-size: 1.4rem;
`
var P1 = styled.p`
  transform: translate(10%, -720%);
  width: 75%;
  font-size: 1.6rem;
`
var P2 = styled.p`
  transform: translate(10%, -700%);
  width: 75%;
  font-size: 1.6rem;
`
var P3 = styled.p`
  transform: translate(10%, -260%);
  width: 90%;
  margin-bottom: 50px;
  font-size: 1.4rem;
`
var P4 = styled.p`
  transform: translate(10%, -750%);
  width: 75%;
  font-size: 1.6rem;
`
var P5 = styled.p`
  transform: translate(10%, -420%);
  width: 90%;
  margin-bottom: 50px;
  font-size: 1.4rem;
`

class Body extends React.PureComponent {
  render() {
    return (
      <Div>
        
        <Img src={profile} alt="profile picture" />
        <H1>Hello</H1>
        <H2>Im Josh McMahan</H2>

        <H3>Age: 27</H3>
        <H3>E-mail: Joshua.McMahan@okstate.edu</H3>
        <H3>Phone#: (918) 555-8156</H3>
        <H3>Occupation: Student</H3>

        <P1>
          <u>About me:</u>
        </P1>
        <P>
          I am current attending Oklahoma State University seeking a bacholers
          degree in Computer Science. I am in my senior year and plan to gradute
          in May of 2019. Once I gradute I wish to work as a software developer.
          I have a pation for technology and will continue to challenging myself
          while learning new and better ways to code.
        </P>

        <P2>
          <u>Experience:</u>
        </P2>
        <P3>
          Since I am still a student I dont have a ton of experience, but I have
          worked on some pretty interesting projects over the last few years. I
          made a Minesweeper game, built web applications, mobile applications,
          and done some work with robot vision.
        </P3>

        <P4>
          <u>Skills:</u>
        </P4>
        <P5>
          I am hardworking, dedicated, able to work well on my own or in a group
          enviroment. I am effeciant in many different programming languages
          such as Java, Python, C++, C, Javascript, and Swift.
        </P5>
        

        <a href="https://github.com/JoshMcMahan">
          <Img2 src={Github} alt="github icon" />
        </a>
        <a href="https://www.facebook.com/dmc2036?ref=bookmarks">
          <Img2 src={Facebook} alt="facebook icon" />
        </a>
        <a href="https://www.linkedin.com/in/joshua-mcmahan-324182157/">
          <Img2 src={Linkedin} alt="linkedin icon" />
        </a>
      </Div>
    )
  }
}

export default Body

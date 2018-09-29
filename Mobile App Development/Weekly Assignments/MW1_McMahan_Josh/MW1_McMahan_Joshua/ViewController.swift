//
//  ViewController.swift
//  MW1_McMahan_Joshua
//
//  Created by Joshua B McMahan on 9/28/18.
//  Copyright © 2018 Joshua B McMahan. All rights reserved.
//

import UIKit
import Foundation

class ViewController: UIViewController {

    
    @IBOutlet weak var laps: UILabel!
    @IBOutlet weak var totalTime: UILabel!
    @IBOutlet weak var lapTime: UILabel!
    @IBOutlet weak var nextLapBtn: UIButton!
    
    var userLap:Int = 0
    var nextUserLap:Int = 1
    var timer:Timer!
    var time: Double = 0
    var startTimer: Int = 0
    var isPaused = true
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    //changes the text and color of the button when pressed
    @IBAction func startStopButton(_ sender: UIButton) {
        let currentState = sender.titleLabel?.text
        
        switch(currentState){
        case "Start":
            sender.setTitle("Stop", for: .normal)
            sender.setTitleColor(.red, for: .normal)
            updateLap()
            handleTimerStart()
            self.nextLapBtn.isHidden = true
            break
        case "Stop":
            sender.setTitle("Start", for: .normal)
            sender.setTitleColor(.black, for: .normal)
            self.nextLapBtn.isHidden = false
            handleTimerStart()
            
            break
        default:
            break
        }
    }
    
    @IBAction func handleNextLap(_ sender: UIButton) {
        nextLapUpdater()
    }
    
    //updates the lap to 1 from 0 but never past that
    func updateLap() {
            self.userLap = 1
            laps.text = String(userLap)
        
    }
    //updates the lap number when the next lap button is pressed
    func nextLapUpdater() {
        if userLap >= 1 {
            self.userLap = userLap + 1
            laps.text = String(userLap)
            
        }
    }
    //starts the timers for both lap time and total laps. handles the pausing and resuming of the timer
    func handleTimerStart() {
        if isPaused == true {
            timer = Timer.scheduledTimer(withTimeInterval: 0.1, repeats: true, block: {_ in self.lapTime.text = self.createFormattedTimeString(time: self.startTimer)
            self.totalTime.text = self.createFormattedTimeString(time: self.startTimer)
            self.startTimer = self.startTimer + 1
            self.isPaused = false
            })}else {
            timer.invalidate()
            isPaused = true
        }
    }
    //allows the time to be displayed in a more normal format
    func createFormattedTimeString(time: Int) -> String {
        let hours = String(time / 36000)
        let minutes = String(time % 36000 / 600)
        let seconds = String(time % 36000 % 600 / 10)
        let tenthofasecond = String(time % 10)
        return "\(hours):\(minutes):\(seconds):\(tenthofasecond)"
    }
    
}


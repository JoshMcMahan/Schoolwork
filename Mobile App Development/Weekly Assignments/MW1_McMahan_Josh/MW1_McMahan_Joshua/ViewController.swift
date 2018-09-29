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
    
    var userLap:Int = 0
    var nextUserLap:Int = 1
    var timer:Timer!
    var time: Double = 0
    var startTimer: Int = 0
    var stopTimer: Double = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    
    @IBAction func startStopButton(_ sender: UIButton) {
        let currentState = sender.titleLabel?.text
        
        switch(currentState){
        case "Start":
            sender.setTitle("Stop", for: .normal)
            sender.setTitleColor(.red, for: .normal)
            updateLap()
            handleTimerStart()
            break
        case "Stop":
            sender.setTitle("Start", for: .normal)
            sender.setTitleColor(.black, for: .normal)
            
            break
        default:
            break
        }
    }
    func updateLap() {
            self.userLap = 1
            laps.text = String(userLap)
        
    }
    func nextLapUpdater() {
        
        if nextUserLap >= 1 {
            self.nextUserLap = nextUserLap + 1
            laps.text = String(nextUserLap)
            
        }
    }
    
    func handleTimerStart() {
        startTimer = 0
        timer = Timer.scheduledTimer(withTimeInterval: 0.1, repeats: true, block: {_ in self.lapTime.text = self.createFormattedTimeString(time: self.startTimer)
            self.totalTime.text = self.createFormattedTimeString(time: self.startTimer)
            self.startTimer = self.startTimer + 1
        })
    }
    
    func createFormattedTimeString(time: Int) -> String {
        
        let hours = String(time / 36000)
        let minutes = String(time % 36000 / 600)
        let seconds = String(time % 36000 % 600 / 10)
        let tenthofasecond = String(time % 10)
        return "\(hours):\(minutes):\(seconds):\(tenthofasecond)"
    }

        
    
}


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
    @IBOutlet weak var handleDTapBtn: UIButton!
    
    var userLap:Int = 0
    var nextUserLap:Int = 1
    var timer:Timer!
    var startTimer: Int = 0
    var userLapTimer: Int = 0
    var isPaused = true
    var userLapTimes = [Int] ()
    var sum: Int = 0
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        //changes the button corners to rounded
        nextLapBtn.layer.cornerRadius = 20
        let tap = UITapGestureRecognizer(target: self, action: #selector(resetAll))
        tap.numberOfTapsRequired = 2
        handleDTapBtn.addGestureRecognizer(tap)
 
    }
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        
        // Hide the navigation/toolbar on the this view controller
        self.navigationController?.setNavigationBarHidden(true, animated: animated)
        self.navigationController?.setToolbarHidden(true, animated: animated)
    }
        
        override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
            
            
        self.navigationController?.setNavigationBarHidden(false, animated: animated)
        self.navigationController?.setToolbarHidden(false, animated: animated)
    }
    
    //changes the text and color of the button when pressed
    @IBAction func startStopButton(_ sender: UIButton) {
        let currentState = sender.titleLabel?.text
        //need to change from switch to if??
        switch(currentState){
        case "Start":
            sender.setTitle("Stop", for: .normal)
            sender.setTitleColor(.red, for: .normal)
            updateLap()
            handleTimerStart()
            self.nextLapBtn.isHidden = false
            break
        case "Stop":
            sender.setTitle("Start", for: .normal)
            sender.setTitleColor(.black, for: .normal)
            self.nextLapBtn.isHidden = true
            handleTimerStart()
            break
        default:
            break
        }
    }
    // updates the number of laps as long as laps = 1
    @IBAction func handleNextLap(_ sender: UIButton) {
        nextLapUpdater()
        userLapTimes.append(userLapTimer)
        userLapTimer = 0
        self.lapTime.text = Helper.createFormattedTimeString(time: userLapTimer)
        
    }
    
    
    @objc func resetAll(){
        userLap = 0
        userLapTimer = 0
        startTimer = 0
        userLapTimes = []
        laps.text = String(userLap)
        lapTime.text = Helper.createFormattedTimeString(time: self.userLapTimer)
        totalTime.text = Helper.createFormattedTimeString(time: self.startTimer)
        timer.invalidate()
    }
    
    //updates the lap to 1 from 0 but never past that
    func updateLap() {
        if userLap == 0 {
            self.userLap = 1
            laps.text = String(userLap)
            
        }
        
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
            timer = Timer.scheduledTimer(withTimeInterval: 0.1, repeats: true, block: {_ in self.lapTime.text = Helper.createFormattedTimeString(time: self.userLapTimer)
                self.totalTime.text = Helper.createFormattedTimeString(time: self.startTimer)
                self.userLapTimer = self.userLapTimer + 1
                self.startTimer = self.startTimer + 1
                self.isPaused = false
            })}else {
            timer.invalidate()
            isPaused = true
        }
    }

    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let lapTimeSegue = segue.destination as! LapTimesTableViewController
        lapTimeSegue.myDataSource = self.userLapTimes
    }
    
}


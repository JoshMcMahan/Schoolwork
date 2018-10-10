//
//  Helper.swift
//  MW1_McMahan_Joshua
//
//  Created by joshua mcmahan on 10/9/18.
//  Copyright © 2018 Joshua B McMahan. All rights reserved.
//

import UIKit

class Helper: NSObject {

    //allows the time to be displayed in a more normal format
    public static func createFormattedTimeString(time: Int) -> String {
        let hours = String(time / 36000)
        let minutes = String(time % 36000 / 600)
        let seconds = String(time % 36000 % 600 / 10)
        let tenthofasecond = String(time % 10)
        return "\(hours):\(minutes):\(seconds).\(tenthofasecond)"
    }
    
}

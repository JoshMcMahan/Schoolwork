//
//  Cash.swift
//  W01_McMahan_Josh
//
//  Created by joshua mcmahan on 8/25/18.
//  Copyright © 2018 joshua mcmahan. All rights reserved.
//

import Foundation

public class Cash {
    private var Currency = 0.0
    
    public func getMoney() -> [Int]? {
        var moneyOwed = self.Currency
        var money = Array(repeating: 0, count: 9)
        
        if moneyOwed < 0 {
            return nil
        }
        
        while 50 <= moneyOwed {
            moneyOwed -= 50
            money[0] = money[0] + 1
        }
        while 20 <= moneyOwed {
            moneyOwed -= 20
            money[1] = money[1] + 1
        }
        while 10 <= moneyOwed {
            moneyOwed -= 10
            money[2] = money[2] + 1
        }
        while 5 <= moneyOwed {
            moneyOwed -= 5
            money[3] = money[3] + 1
        }
        while 1 <= moneyOwed {
            moneyOwed -= 1
            money[4] = money[4] + 1
        }
        while 0.2499 <= moneyOwed {
            moneyOwed -= 0.25
            money[5] = money[5] + 1
        }
        while 0.0999 <= moneyOwed {
            moneyOwed -= 0.10
            money[6] = money[6] + 1
        }
        while 0.0499 <= moneyOwed {
            moneyOwed -= 0.05
            money[7] = money[7] + 1
        }
        while 0.0099 <= moneyOwed {
            moneyOwed -= 0.01
            money[8] = money[8] + 1
        }
        
        return money
    }
    
    public init(Currency: Double) {
        self.Currency = floor(Currency * 100) / 100
        
    }
    
}

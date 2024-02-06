//
//  JourneyRequestDTO.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 11/19/23.
//

import Foundation

struct GetJourneyRequestDTO: Encodable {
    let query: String
}

struct CreateJourneyRequestDTO: Encodable {
    let journeyName: String
    let journeyDestination: String
    var journeyStartDate: String
    var journeyEndDate: String
    
    init(journeyName: String, journeyDestination: String, startDate: Date = Date(), endDate: Date = Date()) {
        let dateFormatter = DateFormatter()
        dateFormatter.dateFormat = "yyyy-MM-dd"
        
        self.journeyName = journeyName
        self.journeyDestination = journeyDestination
        self.journeyStartDate = dateFormatter.string(from: startDate)
        self.journeyEndDate = dateFormatter.string(from: endDate)
    }
}

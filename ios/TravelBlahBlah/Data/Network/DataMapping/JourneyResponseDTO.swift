//
//  JourneyResponseDTO.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 11/19/23.
//

import Foundation

// MARK: - Get Journey List

struct JourneyResponseDTO: Decodable {
    
}


// MARK: - Create Journey

struct CreateJourneyResponseDTO: Decodable {
    let status: String
    let message: String
    let data: CreateJourneyDTO
}

struct CreateJourneyDTO: Decodable {
    let journeyId: Int
    let userId: Int
    let journeyName: String
    let journeyDestination: String
    let journeyStartDate: String
    let journeyEndDate: String
    let journeyCreateDate: String
    let journeyUpdateDate: String
    let journeyDeleteYn: String
}

struct CreateJourneyErrorDTO: Decodable {
    let errorMessage: String
    let errorCode: Int
}

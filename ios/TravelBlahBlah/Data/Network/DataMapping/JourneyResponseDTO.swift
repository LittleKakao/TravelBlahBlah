//
//  JourneyResponseDTO.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 11/19/23.
//

import Foundation

// MARK: - Get Journey List

struct GetJourneyResponseDTO: Decodable {
    let status: String
    let message: String
    let data: JourneyDTO
}

// MARK: - Create Journey

struct CreateJourneyResponseDTO: Decodable {
    let status: String
    let message: String
    let data: JourneyDTO
}

struct CreateJourneyErrorDTO: Decodable {
    let errorMessage: String
    let errorCode: Int
}

// MARK: - Common
struct JourneyDTO: Decodable {
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

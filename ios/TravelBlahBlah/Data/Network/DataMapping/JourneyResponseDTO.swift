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
    let success: Bool
    let journey: CreateJourneyDTO?
    let error: CreateJourneyErrorDTO?
}

struct CreateJourneyDTO: Decodable {
    let journeyId: Int
    let journeyNm: String
    let journeyDest: String
}

struct CreateJourneyErrorDTO: Decodable {
    let errorMessage: String
    let errorCode: Int
}

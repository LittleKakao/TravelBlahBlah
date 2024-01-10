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
    let journeyNm: String
    let journeyDest: String
}

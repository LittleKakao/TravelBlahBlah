//
//  JourneyResponseStorage.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 1/5/24.
//

import Foundation

protocol JourneyResponseStorage {
    func getResponse(
        for request: GetJourneyRequestDTO,
        completion: @escaping (Result<GetJourneyRequestDTO?, Error>) -> Void
    )
    func save(response: CreateJourneyResponseDTO, for requestDto: CreateJourneyRequestDTO)
}

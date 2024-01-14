//
//  CreateJourneyUseCase.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 12/28/23.
//

import Foundation

protocol CreateJourneyUseCase {
    func execute(
        requestValue: CreateJourneyUseCaseRequestValue,
        completion: @escaping (Result<CreateJourneyResponseDTO, Error>) -> Void
    ) -> Cancellable?
}

struct CreateJourneyUseCaseRequestValue {
    let journeyNm: String
    let journeyDest: String
}

final class DefaultCreateJourneyUseCase: CreateJourneyUseCase {
    
    private let createJourneyRepository: CreateJourneyRepository
    
    init(
        createJourneyRepository: CreateJourneyRepository
    ) {
        self.createJourneyRepository = createJourneyRepository
    }
    
    func execute(
        requestValue: CreateJourneyUseCaseRequestValue,
        completion: @escaping (Result<CreateJourneyResponseDTO, Error>) -> Void
    ) -> Cancellable? {
        
        return createJourneyRepository.createJourney(journeyNm: requestValue.journeyNm, journeyDest: requestValue.journeyDest, completion: { result in
                completion(result)
        })
    }
}

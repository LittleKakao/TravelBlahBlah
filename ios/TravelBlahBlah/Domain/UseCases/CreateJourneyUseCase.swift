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
    let journeyName: String
    let journeyDestination: String
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
        
        return createJourneyRepository.createJourney(journeyName: requestValue.journeyName, journeyDestination: requestValue.journeyDestination, completion: { result in
                completion(result)
        })
    }
}

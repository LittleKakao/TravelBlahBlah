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
        cached: @escaping () -> Void,
        completion: @escaping (Result<Void, Error>) -> Void
    ) -> Cancellable?
}

struct CreateJourneyUseCaseRequestValue {
    let query: JourneyQuery
    let journey: JourneyVO
}

final class DefaultCreateJourneyUseCase: CreateJourneyUseCase {
    
    private let journeyRepository: JourneyRepository
    
    init(
        journeyRepository: JourneyRepository
    ) {
        self.journeyRepository = journeyRepository
    }
    
    func execute(
        requestValue: CreateJourneyUseCaseRequestValue,
        cached: @escaping () -> Void,
        completion: @escaping (Result<Void, Error>) -> Void
    ) -> Cancellable? {
        
        return journeyRepository.fetchJourneyList(
            query: requestValue.query,
            cached: cached
        ) { result in
            completion(result)
        }
    }
}
